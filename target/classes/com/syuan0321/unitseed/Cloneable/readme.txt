/**********************************************************
1.Must implement cloneable interface and override [Object clone()] method, because clone() under Object.java is protected
  This is compile error:
  		Integer x = new Integer(1);
		x = (Integer) x.clone();

2. Keep state of the prototype OBJ
   In JAVA only two ways to create obj:
   a. New instance
   b. Clone the object instance

3.ShadowCopy VS DeepCopy
  a.SC only works get obj, but member instance(address reference) in obj will be the same address  
	    System.out.println("body == body1 : " + (body == body1) );  ==>false
	      
	    System.out.println("body.head == body1.head : " +  (body.head == body1.head)); ==>true 

4.When use DeepCopty through serialization have to be caredul:
  a. All class include member instance class should be serializeable
  b. After writing obj in the stream could not change fields definition any more, if so in deserialization will cause trouble 
 


















***********************************************************/