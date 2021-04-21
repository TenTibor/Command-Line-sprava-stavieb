package others;

// others.Note about building or customer from employees
public class Note {
    String text = "";

    public void editText(String newNote) {
        this.text = newNote;
    }

    public void removeNote() {
        this.text = "";
    }

    public boolean isEmpty() {
        return text.isEmpty();
    }

    public String getText() {
        return text;
    }
}
