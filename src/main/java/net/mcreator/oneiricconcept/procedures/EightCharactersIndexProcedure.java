package net.mcreator.oneiricconcept.procedures;

public class EightCharactersIndexProcedure {
	public static String execute(double branchIndex, double stemIndex) {
		String heavenlyStems = "";
		String earthlyBranches = "";
		heavenlyStems = "\u7532\u4E59\u4E19\u4E01\u620A\u5DF1\u5E9A\u8F9B\u58EC\u7678";
		earthlyBranches = "\u5B50\u4E11\u5BC5\u536F\u8FB0\u5DF3\u5348\u672A\u7533\u9149\u620C\u4EA5";
		return heavenlyStems.substring((int) stemIndex) + "" + earthlyBranches.substring((int) branchIndex);
	}
}
