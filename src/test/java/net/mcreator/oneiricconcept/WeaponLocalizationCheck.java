package net.mcreator.oneiricconcept;

import java.nio.file.*;
import java.util.*;
import net.minecraft.client.resources.language.ClientLanguage;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.*;
import net.minecraft.ChatFormatting;
import net.minecraft.server.packs.*;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.per.primogemcraft.system.weapon.*;
import net.per.primogemcraft.system.wish.WishReports;

public class WeaponLocalizationCheck {
    static void check(boolean ok, String message) { if (!ok) throw new AssertionError(message); }
    static PackResources pack(String path, String id) {
        return new FilePackResources.FileResourcesSupplier(Path.of(path)).openPrimary(
            new PackLocationInfo(id, Component.literal(id), PackSource.DEFAULT, Optional.empty()));
    }
    public static void main(String[] args) throws Exception {
        try (var resources = new MultiPackResourceManager(PackType.CLIENT_RESOURCES,
                List.of(pack(args[1], "pgc"), pack(args[0], "oc")))) {
            check(resources.getNamespaces().contains("oneiricconcept_weapons"), "New namespace is not discoverable");
            for (String locale : List.of("en_us", "zh_cn", "ja_jp")) {
                // Exactly the client loader's namespace discovery and English fallback path.
                var language = ClientLanguage.loadFrom(resources,
                    locale.equals("en_us") ? List.of("en_us") : List.of("en_us", locale), false);
                Language.inject(language);
                var sample = WishReports.number(4, ChatFormatting.AQUA);
                var cases = Map.of(
                    "stardust_baseballer", List.of(WeaponDescription.of("passive_effect", "passive", sample, sample),
                        WeaponDescription.of("sneak_use", "sneak_use", sample, sample),
                        WeaponDescription.of("sneak_swing", "sneak_swing", sample, sample)),
                    "spirtbranchof_ture_law", List.of(WeaponDescription.of("passive_effect", "passive"),
                        WeaponDescription.note("operator"), WeaponDescription.of("right_click_effect", "right_click", sample, sample),
                        WeaponDescription.of("sneak_use", "sneak_use", sample, sample)));
                int checked = 0;
                for (var item : cases.entrySet()) for (var description : item.getValue()) {
                    var prefix = "item.oneiricconcept." + item.getKey();
                    var key = prefix + ".description." + description.text();
                    check(language.has(key), "Untranslated: " + key);
                    var rendered = description.lines(prefix).stream().map(Component::getString).reduce("", (a,b) -> a + "\n" + b);
                    check(!rendered.contains("item.oneiricconcept.") && !rendered.contains("weapon.primogemcraft."), "Raw key: " + rendered);
                    check(!rendered.contains("%s") && !rendered.contains("%%"), "Broken substitution: " + rendered);
                    if (item.getKey().equals("stardust_baseballer") && description.text().equals("sneak_swing"))
                        check(rendered.contains("60%"), "Percent regression: " + rendered);
                    if (locale.equals("zh_cn") && item.getKey().equals("stardust_baseballer") && description.text().equals("passive"))
                        check(rendered.contains("在攻击时有4%"), "Chinese was not selected: " + rendered);
                    checked++;
                }
                System.out.println(locale + ": " + checked + " descriptions resolved through actual ClientLanguage namespace discovery.");
            }
        }
    }
}