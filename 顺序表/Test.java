/**
 * @PACKAGE_NAME: PACKAGE_NAME
 * @NAME: Test
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/7
 **/
public class Test {
    public static void main(String[] args) {
        SequenceImpl sequence=new SequenceImpl();
        for (int i = 0; i <10 ; i++) {
            sequence.add(i,i);
        }
        sequence.display();
        sequence.add(10,1);
        sequence.display();
        System.out.println(sequence.search(1));
        sequence.remove(9);
        sequence.display();
        //sequence.removeAll(2);
        System.out.println("===========");
        sequence.clear();
        sequence.display();

    }


}
