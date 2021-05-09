package org.vs.others.hashing;

import com.sun.tools.javac.util.List;

public class TestConsistentHash {

    public static void main(String[] args) {

        HashFunctionImpl hashFunction = new HashFunctionImpl();
        CacheServer cacheServerA = new CacheServer("A");
        CacheServer cacheServerB = new CacheServer("B");

        ConsistentHash<CacheServer> consistentHash =
                new ConsistentHash<>(hashFunction, 10, List.of(cacheServerA, cacheServerB));

        System.out.println(consistentHash.getCircle());


        System.out.println(consistentHash.get("one"));
        System.out.println(consistentHash.get("two"));
        System.out.println(consistentHash.get("fsdfdsfsdf"));
    }
}
