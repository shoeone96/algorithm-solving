package org.example.stackQueue;

public class leet_DesignCircularQueue {
    int [] queue;
    int front = 0;
    int rear = -1;
    int length = 0;

    public leet_DesignCircularQueue(int k) {
        this.queue = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        this.rear = (this.rear + 1) % this.queue.length;
        this.queue[rear] = value;
        this.length++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        this.front = (this.front + 1) % this.queue.length;
        this.length--;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.queue[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return this.queue[rear];
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isFull() {
        return this.length == this.queue.length;
    }
}
