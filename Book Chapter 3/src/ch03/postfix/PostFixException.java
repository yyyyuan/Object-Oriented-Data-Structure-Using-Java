package ch03.postfix;

public class PostFixException extends RuntimeException
{
  public PostFixException()
  {
    super();
  }

  public PostFixException(String message)
  {
    super(message);
  }
}