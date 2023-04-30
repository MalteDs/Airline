package tests;
import model.Passenger;
import structures.Stack;
import junit.framework.TestCase;
public class StackTest extends TestCase{
    Stack<Passenger> stack;

    public void setUpScenario1(){
        stack = new Stack<>();
    }

    public void setUpScenario2(){
        setUpScenario1();
        try{
            stack.push(new Passenger("Juan", 1, 20, "1A", 1000, false, false, null));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void setUpScenario3(){
        setUpScenario2();
        try{
            stack.push(new Passenger("Andres", 2, 20, "1A", 1000, false, false, null));
            stack.push(new Passenger("Daniel", 3, 20, "1A", 1000, false, false, null));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void testPush(){
        setUpScenario1();
        try{
            stack.push(new Passenger("Juan", 1, 20, "1A", 1000, false, false, null));
            stack.push(new Passenger("Andres", 2, 20, "1A", 1000, false, false, null));
            stack.push(new Passenger("Daniel", 3, 20, "1A", 1000, false, false, null));
        } catch (Exception e){
            fail();
        }
    }

    public void testPush2(){
        setUpScenario1();
        try{
            stack.push(new Passenger("Juan", 1, 20, "1A", 1000, false, false, null));
            stack.push(new Passenger("Andres", 2, 20, "1A", 1000, false, false, null));
            stack.push(new Passenger("Daniel", 3, 20, "1A", 1000, false, false, null));
        } catch (Exception e){
            fail();
        }
        assertEquals("Daniel", stack.peek().getName());
    }

    public void testPop(){
        setUpScenario3();
        try{
            assertEquals("Daniel", stack.pop().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testPop2(){
        setUpScenario3();
        try{
            stack.pop();
            assertEquals("Andres", stack.peek().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testPeek(){
        setUpScenario3();
        try{
            assertEquals("Daniel", stack.peek().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testPeek2(){
        setUpScenario3();
        try{
            stack.pop();
            assertEquals("Andres", stack.peek().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testIsEmpty(){
        setUpScenario1();
        assertTrue(stack.isEmpty());
    }

    public void testIsEmpty2(){
        setUpScenario2();
        assertFalse(stack.isEmpty());
    }

    public void testSize(){
        setUpScenario3();
        assertEquals(3, stack.size());
    }

    public void testSize2(){
        setUpScenario3();
        try{
            stack.pop();
        } catch (Exception e){
            fail();
        }
        assertEquals(2, stack.size());
    }




}
