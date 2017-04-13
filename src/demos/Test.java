package demos;

/**
 * Created by Damian on 4/12/2017.
 */
public class Test {
public static void main(String[]args){
    Person s = new Student("Clara");
    //if (s instanceof Student){}
    ((Student)s).getSID();
}
}
