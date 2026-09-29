package net.mcreator.oneiricconcept;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

/** Verify the file MCreator actually copies, not a differently named development artifact. */
public class ExportCheck {
    private static void check(boolean ok, String message) {
        if (!ok) throw new AssertionError(message);
    }

    public static void main(String[] args) throws Exception {
        var setup = new Properties();
        try (var input = Files.newInputStream(Path.of(args[3]))) {
            setup.load(input);
        }
        check("21.1.232".equals(setup.getProperty("buildFileVersion")),
                "Keep the MCreator 2026.2 setup marker to prevent overwriting the tracked build configuration");
        check(Path.of(args[0]).equals(Path.of(args[1])), "jar output must match MCreator's export_file");
        try (var jar = new JarFile(args[0])) {
            String metadata;
            try (var input = jar.getInputStream(jar.getJarEntry("META-INF/neoforge.mods.toml"))) {
                metadata = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            }
            check(Pattern.compile("(?m)^version\\s*=\\s*\"" + Pattern.quote(args[2]) + "\"\\s*$")
                    .matcher(metadata).find(), "Exported mod version differs from workspace version");
            var dependencies = metadata.split("\\[\\[dependencies\\.oneiricconcept]]");
            int requiredNeo = 0;
            for (String dependency : dependencies) {
                if (!dependency.contains("modId=\"primogemcraft\"")) continue;
                requiredNeo++;
                check(dependency.contains("type=\"required\"") && dependency.contains("versionRange=\"[0,)\""),
                        "Export must require PrimogemCraftNeo without restricting its version");
            }
            check(requiredNeo == 1, "Expected exactly one PrimogemCraftNeo dependency");
            int classes = 0;
            var entries = jar.entries();
            while (entries.hasMoreElements()) {
                var entry = entries.nextElement();
                if (!entry.getName().endsWith(".class")) continue;
                try (var input = jar.getInputStream(entry)) {
                    var bytecode = new String(input.readAllBytes(), StandardCharsets.ISO_8859_1);
                    check(!bytecode.contains("net/mcreator/ceshi/") && !bytecode.contains("net.mcreator.ceshi."),
                            "Legacy PrimogemCraft reference in " + entry.getName());
                }
                classes++;
            }
            check(classes > 0, "Export contains no compiled classes");
            check(jar.getJarEntry("net/mcreator/oneiricconcept/procedures/EventPGCProcedure.class") != null,
                    "Export is missing the event integration");
            System.out.println("MCreator export verified: " + args[2] + ", " + classes + " classes, Neo required without version restrictions.");
        }
    }
}
