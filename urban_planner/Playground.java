package urban_planner;

public class Playground extends Building {

    public Playground() {
        super();
    }

    public Playground(int position, int length, int height) {
        super(position, length, height);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Playground)) {
            return false;
        }
        Playground playground = (Playground) o;
        return super.equals(playground);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
