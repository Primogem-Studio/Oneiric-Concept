package net.mcreator.oneiricconcept.procedures;

public class OProcedure {
	public static void execute() {
		double R_radius = 0;
		double D_delta_theta = 0;
		double C_cycle = 0;
		double T_theta = 0;
		double N_number = 0;
		N_number = 42;
		R_radius = 3;
		D_delta_theta = (2 * Math.PI) / N_number;
		for (int index0 = 0; index0 < (int) N_number; index0++) {
			T_theta = C_cycle * D_delta_theta;
			C_cycle = C_cycle + 1;
		}
	}
}
