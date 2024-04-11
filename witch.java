import java.util.Hashtable;
import java.util.ArrayList; 
public class witch{
    String itemx;
    Integer ax;
    Integer bx;
    Integer a;
    Integer b;
    Hashtable<String,String> spells = new Hashtable <String,String> ();
    ArrayList<String> bag = new ArrayList<String>();
    Double size;
    String method;
    //Constructor of witch the class
    public witch(Integer a, Integer b, Double size){
        this.a = a;
        this.b = b;
        this.spells = new Hashtable <String,String> ();
        this.bag = new ArrayList<String>();
        this.size= size;

    }
    /** Grab something and put it in the bag
     * @param item the name of the thing to grab
     */
    public void grab(String item){ 
        if (bag.contains(item)){
            throw new RuntimeException("You already have "+ item + ".");}
        else{
            method = "grab";
            itemx = item;
            System.out.println("You have picked up " + item);
            bag.add(item);}
    }
    /** Drop something and delete that item from the bag
     * 
     * @param item name of the item needed to be dropped.
     * @return String saying that you have succefully dropped the item.
     */
    public String drop(String item){
        if (bag.contains(item)){
            bag.remove(item);
            method = "drop";
            itemx = item;
            return "You have successfully dropped " + item;}
        else{
            throw new RuntimeException("How would you drop " + item + "while you do not have one?");
        }
    }
    /**Examine whether there are items in the hashtable spells
     * 
     * @param item the item being examined
     */
    public void examine(String item){
        if (spells.size() > 0){
            method = "examine";
            System.out.println("You have learned  " + spells + "\n That is quite a lot!");}
        else{
            throw new RuntimeException("Zero spells remembered? That's bewitching! Let's charm those memory skills, shall we?");
        }
    }
    /**use a object from your bag
     * 
     * @param item the name of the item needed to be used.
     */
    public void use(String item){
        if (bag.contains(item)){
            System.out.println("You are equiped with " + item + "." );
            method = "use";
        }
        else{
            throw new RuntimeException("You can not use it before you had it!");
        }
    }
    /** move a unit from the original position
     * 
     * @param direction the name of the direction player choose to go
     * @return whether it is applicable
     */
    public boolean walk(String direction){
        if (direction == "north"|| direction == "south"||direction == "east"||direction == "west"){
            if (a < 50 && b < 50){
                method = "walk";
                ax = a;
                bx = b;
                if (direction == "north"){
                    b = b+1;
                } 
                if (direction == "south"){
                    b = b-1;
                }
                if (direction == "east"){
                    a += 1;
                }
                if (direction == "west"){
                    a -= 1;
                }
                return true;
            }
            else{
                System.out.print("Blimey, what're yeh doin' there? Those places are off-limits for a reason! Best turn round and leave before yeh get into real trouble.");
                return false;
            }}
        else{
            throw new RuntimeException("which way are you going again?");
        }
    }
    /**move to another position
     * 
     * @param x the x of the new position
     * @param y the y of the new position
     * @return whether the move is applicable
     */
    public boolean fly(int x, int y){
        if (x < 50 && y < 50){
            method = "fly";
            this.ax = a;
            this.bx =b;
            this.a = x;
            this.b = y;
            return true;
        }
        else{
            System.out.print("Blimey, what're yeh doin' there? Those places are off-limits for a reason! Best turn round and leave before yeh get into real trouble.");
            return false;}
    }
    /** reduce the size of the player. 
     * 
     * @return the new size
     */
    public Number shrink(){
        method = "shrink";
        this.size = this.size/2;
        return this.size;
    }
    /**increase the size of the player
     * 
     * @return the new size
     */
    public Number grow(){
        method = "grow";
        size = size*2; 
        return this.size;
    }
    //rest
    public void rest(){
        method = "rest";
        System.out.println("Have a good rest then!");
    }
   
    //can cancel last step (only once) 

    public void undo(){
        if (method == "grab"){
            drop(itemx);
        }
        if (method == "drop"){
            grab(itemx);
        }
        if (method == "examine"){
            System.out.println("Request cancelled");
        }
        if (method == "use"){
            System.out.println("you have put it back to you bag.");
        }
        if (method == "walk"){
            this.a = ax;
            this.b = bx;
        }if (method == "fly"){
            this.a = ax;
            this.b = bx;
        }
        if (method == "shrink"){
            this.size = size*2;}
        if (method == "grow"){
            this.size = size/2;
        }
        if (method == "rest"){
            System.out.println("You can stilk work for 934092509 hours!");
        }
        }
        
    public static void main(String[] args) {
        witch Qiu = new witch(0,0,20.0);
        Qiu.rest();
        Qiu.fly(5,7);
        Qiu.undo();
    }}
        