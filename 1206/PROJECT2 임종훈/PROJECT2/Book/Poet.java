package Book;

public class Poet extends Book {

	@Override
	public int getLateFees(int days) {
		// TODO Auto-generated method stub

		days = 300;
		return 3 * days;
	}
}
