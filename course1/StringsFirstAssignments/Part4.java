import edu.duke.*;

class Part4{
	public void findURLs(String url) {
		URLResource ur = new URLResource(url);
		for(String word : ur.words()){
			String lowerWord=word.toLowerCase();
			if(lowerWord.indexOf("youtube.com") != -1){
				int firstIndex = word.indexOf("\"");
				int lastIndex = word.indexOf("\"", firstIndex+1);
				System.out.println(word.substring(firstIndex+1, lastIndex));

			}
		}
	}

	public void testURL() {
		findURLs("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
	}

	public static void main(String[] args) {
		Part4 url = new Part4();
		url.testURL();
	}
}