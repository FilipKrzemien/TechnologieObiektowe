public abstract class BasicFile {

    protected String name;
    protected String identifier;
    protected Catalog parent;
    protected int depth;

    BasicFile(String name, Catalog parent, int depth) {
        this.name = name;
        this.parent = parent;
        this.depth = depth;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void show();

    public void goUp() {
        try {
            parent.show();
            Main.begin(parent);
        } catch (Exception e) {
            System.out.println("Nie mozna wejsc wyzej");
            Main.glowny.show();
            Main.begin(Main.glowny);
        }
    }

    public int getDepth() {
        return depth;
    }
}
