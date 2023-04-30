package tests;
import structures.HashTable;

import junit.framework.TestCase;
public class HashTableTest extends TestCase {
    private HashTable<String, Integer> hashTable;
    private final int CAPACITY = 10;
    public void setUpScenario1(){
        hashTable = new HashTable<>(CAPACITY);
    }

    public void setUpScenario2(){
        setUpScenario1();
        try{
            hashTable.put("Juan", 30);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void setUpScenario3(){
        setUpScenario2();
        try{
            hashTable.put("Andres", 20);
            hashTable.put("Daniel", 22);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void testPut(){
        setUpScenario1();
        try{
            hashTable.put("Juan", 30);
            hashTable.put("Andres", 20);
            hashTable.put("Daniel", 22);
        } catch (Exception e){
            fail();
        }
    }

    public void testPut2(){
        setUpScenario1();
        try{
            hashTable.put("Juan", 30);
            hashTable.put("Andres", 20);
            hashTable.put("Daniel", 22);
            hashTable.put("Juan", 40);
        } catch (Exception e){
            fail();
        }
        assertEquals(40, (int) hashTable.get("Juan"));
    }

    public void testGet(){
        setUpScenario3();
        assertEquals(20, (int) hashTable.get("Andres"));
    }

    public void testGet2(){
        setUpScenario3();
        assertNull(hashTable.get("Juan"));
    }

    public void testRemove(){
        setUpScenario3();
        hashTable.remove("Andres");
        assertNull(hashTable.get("Andres"));
    }

    public void testRemove2(){
        setUpScenario3();
        hashTable.remove("Juan");
        assertNull(hashTable.get("Juan"));
    }

    public void testRemoveAll(){
        setUpScenario3();
        hashTable.clear();
        assertNull(hashTable.get("Juan"));
        assertNull(hashTable.get("Andres"));
        assertNull(hashTable.get("Daniel"));
    }

    public void testRemoveAll2(){
        setUpScenario3();
        hashTable.clear();
        assertEquals(0, hashTable.size());
    }

    public void testSize(){
        setUpScenario3();
        assertEquals(3, hashTable.size());
    }

    public void testSize2(){
        setUpScenario3();
        hashTable.remove("Juan");
        assertEquals(2, hashTable.size());
    }

    public void testHash(){
        setUpScenario3();
        assertEquals(0, hashTable.hash("Juan"));
        assertEquals(1, hashTable.hash("Andres"));
        assertEquals(2, hashTable.hash("Daniel"));
    }

    public void testHash2(){
        setUpScenario3();
        assertEquals(0, hashTable.hash("Juan"));
        assertEquals(1, hashTable.hash("Andres"));
        assertEquals(2, hashTable.hash("Daniel"));
        assertEquals(0, hashTable.hash("Juan"));
        assertEquals(1, hashTable.hash("Andres"));
        assertEquals(2, hashTable.hash("Daniel"));
    }
}
