package Book;

public class Novel extends Book {

	@Override
	public int getLateFees(int days) {
		// TODO Auto-generated method stub

		days = 700;
		return 3 * days;
	}
}
