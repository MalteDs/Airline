package tests;
import model.Passenger;
import structures.PriorityQueue;
import junit.framework.TestCase;

public class PriorityQueueTest extends TestCase {
    PriorityQueue<Passenger> priorityQueue;

    public void setUpScenario1(){
        priorityQueue = new PriorityQueue<>();
    }

    public void setUpScenario2(){
        setUpScenario1();
        try{
            priorityQueue.enqueue(new Passenger("Juan", 1, 20, "1A", 1000, false, false, null),1);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void setUpScenario3(){
        setUpScenario2();
        try{
            priorityQueue.enqueue(new Passenger("Andres", 2, 20, "1A", 1000, false, false, null),2);
            priorityQueue.enqueue(new Passenger("Daniel", 3, 20, "1A", 1000, false, false, null),3);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void testEnqueue(){
        setUpScenario1();
        try{
            priorityQueue.enqueue(new Passenger("Juan", 1, 20, "1A", 1000, false, false, null),1);
            priorityQueue.enqueue(new Passenger("Andres", 2, 20, "1A", 1000, false, false, null),2);
            priorityQueue.enqueue(new Passenger("Daniel", 3, 20, "1A", 1000, false, false, null),3);
        } catch (Exception e){
            fail();
        }
    }

    public void testEnqueue2(){
        setUpScenario1();
        try{
            priorityQueue.enqueue(new Passenger("Juan", 1, 20, "1A", 1000, false, false, null),1);
            priorityQueue.enqueue(new Passenger("Andres", 2, 20, "1A", 1000, false, false, null),2);
            priorityQueue.enqueue(new Passenger("Daniel", 3, 20, "1A", 1000, false, false, null),3);
        } catch (Exception e){
            fail();
        }
        assertEquals("Juan", priorityQueue.peek().getName());
    }

    public void testDequeue(){
        setUpScenario3();
        try{
            assertEquals("Juan", priorityQueue.dequeue().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testDequeue2(){
        setUpScenario3();
        try{
            assertEquals("Juan", priorityQueue.dequeue().getName());
            assertEquals("Andres", priorityQueue.dequeue().getName());
            assertEquals("Daniel", priorityQueue.dequeue().getName());
        } catch (Exception e){
            fail();
        }
        assertTrue(priorityQueue.isEmpty());
    }

    public void testPeek(){
        setUpScenario3();
        try{
            assertEquals("Juan", priorityQueue.peek().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testPeek2(){
        setUpScenario3();
        try{
            assertEquals("Juan", priorityQueue.peek().getName());
            assertEquals("Juan", priorityQueue.peek().getName());
            assertEquals("Juan", priorityQueue.peek().getName());
        } catch (Exception e){
            fail();
        }
    }

    public void testIsEmpty(){
        setUpScenario1();
        assertTrue(priorityQueue.isEmpty());
    }

    public void testIsEmpty2(){
        setUpScenario2();
        assertFalse(priorityQueue.isEmpty());
    }

    public void testSize(){
        setUpScenario1();
        assertEquals(0, priorityQueue.size());
    }

    public void testSize2(){
        setUpScenario2();
        assertEquals(1, priorityQueue.size());
    }




}
