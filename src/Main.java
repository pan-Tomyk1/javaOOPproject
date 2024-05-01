import java.util.Scanner;

public class Main {
    static MyList myList=new MyList();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.greeting();
        main.addingElements();
        boolean toContinue;
        do{
            Thread.sleep(2000);
            main.printMethods();
            toContinue=main.callingMethods(main.selectMethod());
        }while(toContinue);
    }
    private void greeting(){
        System.out.println("---BUILDING AND USING DATA STRUCTURES---");
        System.out.println("Please add items to the list");
    }
    private void printMethods(){
        System.out.println("1-Add Items to List");
        System.out.println("2-Get item from list");
        System.out.println("3-Print List");
        System.out.println("4-Find element multiple of specified value");
        System.out.println("5-Replace elements located in even positions with \"0\" (numbering starts from the list head)");
        System.out.println("6-Get a new list of element values whose values are greater than the specified value");
        System.out.println("7-Delete items located in odd positions (numbering starts from the list head)");
        System.out.println("8-Finish the program");
    }
    private int selectMethod(){
        System.out.println("Please, select a method, press 1-8");
        return enterNumber(8,1);
    }
    private int enterNumber(int max, int min){
        boolean checkNumber=false;
        int number=0;
        while(!checkNumber){
            try{number=scanner.nextInt();}
            catch(Exception e){
                System.out.println("Invalid input. Please, enter a number");
                scanner.next();
                continue;
            }
            checkNumber=Validation.ValidateNumber(number,max,min);
            if(!checkNumber){
                System.out.println("Invalid input");
            }
        }

        //scanner.close();
        return number;
    }
    private boolean callingMethods(int index){
        switch (index){
            case 1 : addingElements();return true;
            case 2 : {
                System.out.println("Enter the index of the item " +
                        "you want to retrieve from the list" +
                        " min - 0, max "+(myList.size()-1));
                int indexOfElement=enterNumber(myList.size()-1,0);
                System.out.println(myList.get(indexOfElement));
                return true;
            }
            case 3 : myList.printList();return true;
            case 4 : {
                System.out.println("Enter the number for which you want" +
                        " to find multiples in the list");
                int number =enterNumber(Short.MAX_VALUE,Short.MIN_VALUE);
                myList.findMultiples((short) number).printList();
                return true;
            }
            case 5 : {
                myList.replaceEvenPositionElementsWithZero();
                System.out.println("Do you want to see the list");
                if(makeChoice())
                    myList.printList();
                return true;
            }
            case 6 :{
                System.out.println("Enter a value relative " +
                        "to which to create a new list");
                int number =enterNumber(Short.MAX_VALUE,Short.MIN_VALUE);
                myList.getValuesGreaterThanThreshold((short) number).printList();
                return true;
            }
            case 7 : {
                myList.deleteElementsAtNonEvenPositions();
                System.out.println("Do you want to see the list");
                if(makeChoice())
                    myList.printList();
                return true;
            }
            default: break;
        }
        return false;
    }
    private void addingElements(){
        System.out.println("Please enter items, in order to finish typing please enter any letter");
        System.out.println("Maximum value - "+Short.MAX_VALUE+" minimum value - "+Short.MIN_VALUE);
        while(scanner.hasNextShort()){
            myList.add(scanner.nextShort());
        }
        scanner.next();
        System.out.println("Input stopped");
        //console.close();
    }

    private boolean makeChoice(){
        System.out.println("If your answer is yes, press 1," +
                " otherwise press any key");
        //scanner.next();
        String choice=scanner.next();
        //console.close();
        return choice.equals("1");
    }

}
