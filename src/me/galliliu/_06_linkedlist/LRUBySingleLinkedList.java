package me.galliliu._06_linkedlist;

/**
 * 单链表实现LRU缓存淘汰算法
 *
 * @author galliliu
 * @createTime 2018-10-12
 */

public class LRUBySingleLinkedList {
    //缓存列表
    private SingleLinkedList cache;
    //缓存列表最大存储数量
    private int maxCacheSize;

    public LRUBySingleLinkedList() {
        this(10);
    }

    public LRUBySingleLinkedList(int cacheSize) {
        this.cache = new SingleLinkedList();
        this.maxCacheSize = cacheSize;
    }

    /**
     * 寻找缓存
     *
     * @param target 缓存的资源id（一般使用id标识资源，缓存的时候缓存id+资源），这里id和资源同一个
     * @return 根据target寻找缓存中是否有资源，有则返回它，否则返回-1
     */
    public int findCache(int target) {
        if (this.cache.contains(target)) {
            //已存在缓存，把资源移到到第一个节点
            //这里为了方便，先删除原节点后插入到首节点
            //更好的算法是把删除的节点复用，直接移动到头节点
            this.cache.delete(target);
            this.cache.insert(0, target);
            target = this.cache.find(target);//根据资源表示寻找资源
            System.out.println("已存在缓存，把资源移到到第一个节点");
        } else {
            if (this.cache.size() >= this.maxCacheSize) {
                //缓存已经满，释放最后一个节点，然后把当前节点插入到头结点
                this.cache.deleteLast();
                this.cache.insert(0, target);
                System.out.println("缓存已经满，释放最后一个节点，然后把当前节点插入到头结点");
            } else {
                //缓存未满，直接把当前节点插入到头结点
                this.cache.insert(0, target);
                System.out.println("缓存未满，直接把当前节点插入到头结点");
            }
        }
        return target;
    }

    @Override
    public String toString() {
        return this.cache.toString();
    }

    public static void main(String[] args) {
        LRUBySingleLinkedList lruCache = new LRUBySingleLinkedList(3);

        lruCache.findCache(1);
        System.out.println(lruCache);
        lruCache.findCache(2);
        System.out.println(lruCache);
        lruCache.findCache(3);
        System.out.println(lruCache);
        lruCache.findCache(2);
        System.out.println(lruCache);
        lruCache.findCache(4);
        System.out.println(lruCache);
    }
}

