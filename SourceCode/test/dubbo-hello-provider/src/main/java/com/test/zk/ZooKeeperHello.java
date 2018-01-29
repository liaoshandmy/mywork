package com.test.zk;

import java.io.IOException;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class ZooKeeperHello {

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		//ZooKeeper zk = new ZooKeeper("192.168.213.125:2181", 300000, new DemoWatcher());//连接zk server
		/*
		ZooKeeper zk = new ZooKeeper("192.168.213.125:2181,192.168.213.125:2182,192.168.213.125:2183", 300000, new DemoWatcher());//连接zk server
		if (!zk.getState().equals(ZooKeeper.States.CONNECTED)) {
		    while (true) {
				if (zk.getState().equals(ZooKeeper.States.CONNECTED)) {
				   break;
				}
				try {
				   TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
				   e.printStackTrace();
				}
			}
		}
		
		String node = "/app1";
        Stat stat = zk.exists(node, false);//检测/app1是否存在
        if (stat == null) {
            //创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        //获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
        */
		
		ZkClient zkClient = new ZkClient("192.168.213.125:2181,192.168.213.125:2182,192.168.213.125:2183");
        String node = "/app2";
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, "hello zk");
        }
        System.out.println(zkClient.readData(node));
	}
	
	
	static class DemoWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("----------->");
            System.out.println("path:" + event.getPath());
            System.out.println("type:" + event.getType());
            System.out.println("stat:" + event.getState());
            System.out.println("<-----------");
        }
    }
	
}
