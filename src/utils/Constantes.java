package utils;

public class Constantes {

	public static final String ARQUIVO_DE_TEXTO = "assembly";

	public static int SIZE_word = 16; //em bits
	public static int SIZE_ram = 8;
	public static int SIZE_e_s_buffer;

	private static void setSizeBuffer() {
		if (SIZE_ram == 8)
			SIZE_e_s_buffer = 4;
		else if (SIZE_ram == 16)
			SIZE_e_s_buffer = 8;
		else if (SIZE_ram == 32)
			SIZE_e_s_buffer = 16;
	}

	public static int WIDTH_barramento = 8;
	public static String limitMemoryDigits;

	private static void setDigitsLimitMemory() {
		if (WIDTH_barramento == 8 || WIDTH_barramento == 16) {
			limitMemoryDigits = "{1}";
		} else if (WIDTH_barramento == 32) {
			limitMemoryDigits = "{1,2}";
		}
	}

	// Register value
	public static int VALUE_register_A = 300;
	public static int VALUE_register_B = 400;
	public static int VALUE_register_C = 500;
	public static int VALUE_register_D = 600;
	public static int VALUE_register_CI = -5;

	// Instructions
	public static String mov = "mov";
	public static String add = "add";
	public static String inc = "inc";
	public static String imul = "imul";

	// Instructions value 3 a 6
	// r - register ; m - memory ; i - immediate
	public static int VALUE_mov_r_from_r = 311;
	public static int VALUE_mov_r_from_i = 313;
	public static int VALUE_mov_m_from_i = 323;
	public static int VALUE_mov_r_from_m = 312;
	public static int VALUE_mov_m_from_r = 321;
	public static int VALUE_mov_m_from_m = 322;
	public static int VALUE_add_r_from_r = 411;
	public static int VALUE_add_r_from_i = 413;
	public static int VALUE_add_m_from_i = 423;
	public static int VALUE_add_r_from_m = 412;
	public static int VALUE_add_m_from_r = 421;
	public static int VALUE_add_m_from_m = 422;
	public static int VALUE_inc_r = 501;
	public static int VALUE_inc_m = 502;
	public static int VALUE_imul_r_r_r = 6111;
	public static int VALUE_imul_r_r_m = 6112;
	public static int VALUE_imul_r_r_i = 6113;
	public static int VALUE_imul_r_m_r = 6121;
	public static int VALUE_imul_r_m_m = 6122;
	public static int VALUE_imul_r_m_i = 6123;
	public static int VALUE_imul_r_i_r = 6131;
	public static int VALUE_imul_r_i_m = 6132;
	public static int VALUE_imul_r_i_i = 6133;
	public static int VALUE_imul_m_r_r = 6211;
	public static int VALUE_imul_m_r_m = 6212;
	public static int VALUE_imul_m_r_i = 6213;
	public static int VALUE_imul_m_m_r = 6221;
	public static int VALUE_imul_m_m_m = 6222;
	public static int VALUE_imul_m_m_i = 6223;
	public static int VALUE_imul_m_i_r = 6231;
	public static int VALUE_imul_m_i_m = 6232;
	public static int VALUE_imul_m_i_i = 6233;

	// Instructions REgex
	public static String RE_add_mov;
	public static String RE_inc;
	public static String RE_imul;

	// Componentes REgex
	public static String RE_register = "[A-D]";
	public static String RE_memory = "0x[a-fA-F0-9]" + "";
	public static String RE_immediate = "\\d+";

	static {
		setDigitsLimitMemory();
		setSizeBuffer();
		RE_add_mov = "^(add|mov)\\s+([a-dA-D]|0x[a-fA-F0-9]" + limitMemoryDigits + ")\\s*,"
				+ "\\s+([a-dA-D]|0x[a-fA-F0-9]+|\\d+)\\s*$";
		RE_inc = "^(inc)\\s+([a-dA-D]|0x[a-fA-F0-9]" + limitMemoryDigits + ")\\s*$";
		RE_imul = "^(imul)\\s+([a-dA-D]|0x[a-fA-F0-9] " + limitMemoryDigits + ")\\s*," + "\\s+([a-dA-D]|0x[a-fA-F0-9]"
				+ limitMemoryDigits + "|\\d)\\s*," + "\\s+([a-dA-D]|0x[a-fA-F0-9]" + limitMemoryDigits + "|\\d+)\\s*$";
	}

}