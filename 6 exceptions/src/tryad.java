public class tryad {
    private static int userNumber  = 0 ;
    
    public tryad(){
        userNumber ++;
    }
    
    public static void main(String[] args) {
        tryad user1 = new tryad();
        tryad user2 = new tryad();
        
        System.out.println("user1 userNumber：" + tryad.userNumber);
        System.out.println("user2 userNumber：" + tryad.userNumber);
    }
}    