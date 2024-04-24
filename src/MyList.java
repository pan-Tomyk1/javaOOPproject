import java.util.ArrayList;
import java.util.List;

public class MyList{
    List<Short> arrayList;

    public MyList(){
        arrayList=new ArrayList<>();
    }

    public void addElement(short element){
        arrayList.add(element);
    }

    public short getElement(int index){
        if(!Validation.ValidateNumber(index,this.arrayList.size(),0))
            return Short.MIN_VALUE;
        return arrayList.get(index);
    }

    public List<Short> findMultiples(short number){
        List<Short> multiples = new ArrayList<>();
        for (short element : this.arrayList) {
            if (element % number == (short) 0) {
                multiples.add(element);
            }
        }
        return multiples;
    }
    public void replaceEvenPositionElementsWithZero(){
        for (int i = 0; i <this.arrayList.size() ; i++) {
            if(i%2==0){
                this.arrayList.set(i,(short)0);
            }
        }
    }

    public List<Short> getValuesGreaterThanThreshold(short number){
        List<Short> list = new ArrayList<>();
        for (short s:this.arrayList){
            if(number<s){
                list.add(s);
            }
        }
        return list;
    }
    public void deleteElementsAtNonEvenPositions(){
        for (int i = this.arrayList.size(); i >=0; i--) {
            if(i%2!=0){
                this.arrayList.remove(i);
            }
        }
    }
}
