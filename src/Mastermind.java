import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Mastermind {
	
//	Code Colors
//	
//	cyan = 1
//	magenta = 2
//	orange = 3
//	yellow = 4
//	green = 5
	
	
//	Feedback Colors
//	
//	red = R		(right color, right place)
//	white = W	(right color, wrong place)
	
	static List<Integer> code = new ArrayList<Integer>();
	static List<Integer> guess = List.of(1, 2, 3, 4);	// temporary. pseudo guess until I make an actual way to guess

	
// Generate a new four digit code
	public static void newCode() {
		
		code.clear();
		for (int i = 0; i < 4; i++) {
			code.add( (int)(Math.random() * 5) + 1 ); 	// adds rands 1-5
		}
		
	}
	
//	create feedback from guess
	public static List<Character> feedback(List<Integer> guess) {

		List<Character> feedback = new ArrayList<Character>();
		
		int reds = 0;			// count for each color
		int whites = 0;
		
//		Check for number of reds and whites
		for (int i = 0; i < 4; i++) {
			if (guess.get(i) == code.get(i)) {
				reds++;
			} else if (code.contains(guess.get(i))) {
				whites++;
			}
		}
		
//		Add 0s and 1s to feedback list
		for (int i = 0; i < reds; i++) {
			feedback.add('R');
		}
		
		for (int i = 0; i < whites; i++) {
			feedback.add('W');
		}
		
		return feedback;
	
	}
	
	
	
	public static void main(String[] args) {
		newCode();
		System.out.println("Code: " + code);
		System.out.println("Guess: " + guess);
		System.out.println("Feedback: " + feedback(guess));
	}
	
}
