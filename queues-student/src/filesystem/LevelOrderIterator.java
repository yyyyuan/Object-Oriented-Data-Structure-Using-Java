package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.*;
import sun.security.x509.IssuingDistributionPointExtension;


/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {
	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	
	Queue<File> queue;
	
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
        	// TODO 1
		
		if (!rootNode.exists()) {
			throw new FileNotFoundException("The input node is not in the file system");
		}
		
		else {
			queue = new Queue<File> ();
			File[] temp;
			queue.enqueue(rootNode);
			Node<File> index = queue.front;
			
			while (index != null) {
				if (index.getData().isDirectory()) {
					
					temp = index.getData().listFiles();
					
					java.util.Arrays.sort(temp);

					for (int i = 0; i < temp.length; i++) {
						queue.enqueue(temp[i]);
					}
					
					index = index.getNext();
					
				}
				else {
					index = index.getNext();
				}
			}
		}
	}
	
	@Override
	public boolean hasNext() {
        	// TODO 2
		
		return queue.size() != 0;
	}

	@Override
	public File next() throws NoSuchElementException {
        	// TODO 3
		
		if (!hasNext()) {
			throw new NoSuchElementException("There is no file exists any more");
		}	
		else {
			
			File data = queue.dequeue();
			
			return data;
		}	
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

	
}
