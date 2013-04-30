package edu.ggc.jdavis37;

public class MyLinkList
{
	private MyLinkNode current = new MyLinkNode();
	
	public boolean hasNext()
	{
		if(current.getNextNode() != null)
		{
			return true;
		}
		return false;
	}
	
	public boolean hasPrevious()
	{
		if(current.getPreviousNode() != null)
		{
			return true;
		}
		return false;
	}
	
	public MyLinkNode getFirst()
	{
		while(this.hasPrevious())
		{
			current = current.getPreviousNode();
		}
		return current;
	}
	
	
	public MyLinkNode getLast()
	{
		while(this.hasNext())
		{
			current = current.getNextNode();
		}
		return current;
	}
	
	public void add(String str)
	{
		MyLinkNode newNode = new MyLinkNode();
		this.getLast();
		newNode.setData(str);
		if(current.getData() != null)
		{
			newNode.setPreviousNode(current);
			current.setNextNode(newNode);
			current = newNode;
		}
		else
		{
			current.setData(str);
		}
	}
	
	public void addFirst(String str)
	{
		this.getFirst();
		MyLinkNode newNode = new MyLinkNode();
		newNode.setData(str);
		current.setPreviousNode(newNode);
		newNode.setNextNode(current);
		current = newNode;
	}
	
	public MyLinkNode next()
	{
		if(this.hasNext())
		{
			current = current.getNextNode();
		}
		return current;
	}
	
	@Override
	public String toString()
	{
		String ret = "";
		this.getFirst();
		boolean next = hasNext();
		while(next)
		{
			ret = String.format("%s %s",ret, current.getData());
			if (hasNext())
			{
				this.next();
			}
			else 
			{
				next = false;
			}
			
		}
		
		if(ret.length() > 1)
		{
			ret += ".";
		}
		
		return ret;
	}
}
