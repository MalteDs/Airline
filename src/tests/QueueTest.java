package tests;
import structures.Queue;
import junit.framework.TestCase;
public class QueueTest extends TestCase {
    private Queue<Integer> queue;
    public void setUpScenario1(){
        queue = new Queue<>();
    }

    public void setUpScenario2(){
        setUpScenario1();
        try{
            queue.enqueue(1);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void setUpScenario3(){
        setUpScenario2();
        try{
            queue.enqueue(2);
            queue.enqueue(3);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void testEnqueue(){
        setUpScenario1();
        try{
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
        } catch (Exception e){
            fail();
        }
    }

    public void testEnqueue2(){
        setUpScenario1();
        try{
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
        } catch (Exception e){
            fail();
        }
        assertEquals(1, (int) queue.peek());
    }

    public void testDequeue(){
        setUpScenario3();
        try{
            assertEquals(1, (int) queue.dequeue());
            assertEquals(2, (int) queue.dequeue());
            assertEquals(3, (int) queue.dequeue());
        } catch (Exception e){
            fail();
        }
    }

    public void testDequeue2(){
        setUpScenario3();
        try{
            assertEquals(1, (int) queue.dequeue());
            assertEquals(2, (int) queue.dequeue());
            assertEquals(3, (int) queue.dequeue());
        } catch (Exception e){
            fail();
        }
        assertTrue(queue.isEmpty());
    }

    public void testPeek(){
        setUpScenario3();
        try{
            assertEquals(1, (int) queue.peek());
            assertEquals(1, (int) queue.peek());
        } catch (Exception e){
            fail();
        }
    }

    public void testPeek2(){
        setUpScenario3();
        try{
            assertEquals(1, (int) queue.peek());
            assertEquals(1, (int) queue.peek());
        } catch (Exception e){
            fail();
        }
        assertEquals(3, queue.size());
    }

    public void testIsEmpty(){
        setUpScenario1();
        assertTrue(queue.isEmpty());
    }

    public void testIsEmpty2(){
        setUpScenario2();
        assertFalse(queue.isEmpty());
    }

    public void testSize(){
        setUpScenario3();
        assertEquals(3, queue.size());
    }

    public void testSize2(){
        setUpScenario3();
        assertEquals(3, queue.size());
        try{
            queue.dequeue();
        } catch (Exception e){
            fail();
        }
        assertEquals(2, queue.size());
    }

    public void testContains(){
        setUpScenario3();
        assertTrue(queue.contains(2));
        assertFalse(queue.contains(4));
    }

    public void testContains2(){
        setUpScenario3();
        assertTrue(queue.contains(2));
        assertFalse(queue.contains(4));
        try{
            queue.dequeue();
        } catch (Exception e){
            fail();
        }
        assertFalse(queue.contains(2));
    }
}
