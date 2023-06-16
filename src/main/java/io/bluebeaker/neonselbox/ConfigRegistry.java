package io.bluebeaker.neonselbox;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigRegistry {
	private static final ForgeConfigSpec.Builder CFGC = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec CLIENT_CONFIG;
	public static ForgeConfigSpec.BooleanValue Enable;
	public static ForgeConfigSpec.DoubleValue Red;
	public static ForgeConfigSpec.DoubleValue Green;
	public static ForgeConfigSpec.DoubleValue Blue;
	public static ForgeConfigSpec.DoubleValue Alpha;
	public static ForgeConfigSpec.DoubleValue Red2;
	public static ForgeConfigSpec.DoubleValue Green2;
	public static ForgeConfigSpec.DoubleValue Blue2;
	public static ForgeConfigSpec.DoubleValue Alpha2;
	public static ForgeConfigSpec.IntValue BlinkInterval;
	public static ForgeConfigSpec.DoubleValue Width;
	public static ForgeConfigSpec.BooleanValue DisableDepth;
	static{
		initConfig();
	}
	private static void initConfig(){
		Enable=CFGC.comment("Enable Neon Selection Box.").define("enable",true);
	//Color 1
		Red=CFGC.comment("Red").defineInRange("main_color.red",0.0,0.0,1.0);
		Green=CFGC.comment("Green").defineInRange("main_color.green",0.0,0.0,1.0);
		Blue=CFGC.comment("Blue").defineInRange("main_color.blue",0.0,0.0,1.0);
		Alpha=CFGC.comment("Alpha").defineInRange("main_color.alpha",0.4,0.0,1.0);
	//Color 2
		Red2=CFGC.comment("Red").defineInRange("secondary_color.red",0.0,0.0,1.0);
		Green2=CFGC.comment("Green").defineInRange("secondary_color.green",0.0,0.0,1.0);
		Blue2=CFGC.comment("Blue").defineInRange("secondary_color.blue",0.0,0.0,1.0);
		Alpha2=CFGC.comment("Alpha").defineInRange("secondary_color.alpha",0.4,0.0,1.0);
		BlinkInterval=CFGC.comment("Blink Interval. Set 0 to disable blinking.").defineInRange("blink_interval",0,0,2147483647);
		Width=CFGC.comment("Line Width").defineInRange("width",1.0,0.0,100.0);
		DisableDepth=CFGC.comment("Disable Depth.").define("disable_depth",false);
		CLIENT_CONFIG = CFGC.build();
	}
}
