package edu.ggc.jdavis37;

public class MyLinkNode
{
	private MyLinkNode previousNode;
	private MyLinkNode nextNode;
	private String data;
	
	public MyLinkNode()
	{
		previousNode = null;
		nextNode = null;
		data = (String) null;
	}
	
	/**
	 * @return the previousNode
	 */
	public MyLinkNode getPreviousNode() 
	{
		return previousNode;
	}
	/**
	 * @param previousNode the previousNode to set
	 */
	public void setPreviousNode(MyLinkNode previousNode) 
	{
		this.previousNode = previousNode;
	}
	/**
	 * @return the nextNode
	 */
	public MyLinkNode getNextNode()
	{
		return nextNode;
	}
	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(MyLinkNode nextNode) 
	{
		this.nextNode = nextNode;
	}
	/**
	 * @return the data
	 */
	public String getData() 
	{
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) 
	{
		this.data = data;
	}

}
