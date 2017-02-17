package ch06;

public class Circle implements Comparable<Circle>
{
  protected float radius;
  protected static final float PI = 3.14f;
      
  public Circle(float radius)
  {
    this.radius = radius;
  }    
    
  public boolean equals(Circle circle)
  // Precondition: circle != null
  //
  // Returns true if the circles have the same radius;
  // otherwise, returns false.
  {
    if (this.radius == circle.radius)
      return true;
    else
      return false;
  }
  
  public int compareTo(Circle o)
  // Precondition: o != null
  //
  // Returns a negative integer, zero, or a positive integer as this Circle 
  // is less than, equal to, or greater than the parameter Circle.
  {
    if (this.radius < o.radius)
      return -1;
    else
      if (this.radius == o.radius)
        return 0;
      else
        return 1;
  }
       
  public float perimeter()
  // Returns perimeter of this figure.
  {
    return(2 * PI * radius);
  }
   
  public float area()
  // Returns area of this figure.
  {
    return(PI * radius * radius);
  }
}
