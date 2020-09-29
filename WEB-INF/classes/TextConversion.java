class TextConversion{
	public static String textReplace(String text){
		String afterText = text.replace("&","&amp").replace("<","&lt").replace(">","&gt").replace("\"","&quot").replace("'","&#39");
		return afterText;
	}
}