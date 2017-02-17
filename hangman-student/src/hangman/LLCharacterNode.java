package hangman;

public class LLCharacterNode {
	  private char info;
	  private LLCharacterNode link;

	  public LLCharacterNode(char info)
	  {
	    this.info = info;
	    link = null;
	  }

	  public void setInfo(char info)
	  // Sets info string of this LLStringNode.
	  {
	    this.info = info;
	  }

	  public char getInfo()
	  // Returns info string of this LLStringNode.
	  {
	    return info;
	  }

	  public void setLink(LLCharacterNode link)
	  // Sets link of this LLStringNode.
	  {
	    this.link = link;
	  }

	  public LLCharacterNode getLink()
	  // Returns link of this LLStringNode.
	  {
	    return link;
	  }   
}
