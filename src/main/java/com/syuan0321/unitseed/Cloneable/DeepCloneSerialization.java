package com.syuan0321.unitseed.Cloneable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCloneSerialization {
	static class Body implements Cloneable, Serializable {
		private static final long serialVersionUID = 1L;
		public Head head;

		public Body() {
		}

		public Body(Head head) {
			this.head = head;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Body newBody = (Body) super.clone();
			return newBody;
		}
		
	    public Object deepClone() throws Exception
	    {	
	    	//Serialization
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(bos);

	        oos.writeObject(this);

	        //Deserialization
	        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
	        ObjectInputStream ois = new ObjectInputStream(bis);

	        return ois.readObject();
	    }		

	}

	static class Head implements Cloneable, Serializable {
		private static final long serialVersionUID = 1L;

		public Head() {
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	public static void main(String[] args) throws Exception {

		Body body = new Body(new Head());

		Body body1 = (Body) body.clone();

		Body body2 = (Body) body.deepClone();
		
		System.out.println("body == body1 : " + (body == body1));

		System.out.println("body.head == body1.head : " + (body.head == body1.head));

		System.out.println("body == body2 : " + (body == body2));

		System.out.println("body.head == body2.head : " + (body.head == body2.head));
	}
}
