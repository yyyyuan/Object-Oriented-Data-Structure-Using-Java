package filesystem;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class PublicLevelOrderIteratorTest {
	@Rule
    public Timeout timeout = new Timeout(10L, TimeUnit.SECONDS);
	
	File tempFile;
	LevelOrderIterator singleIterator;
	
	File tempDir;
	LevelOrderIterator nestedDirIterator;

	File emptyDir;
	LevelOrderIterator emptyDirIterator;
	
	File subDir;
	
	File leafDir;
	LevelOrderIterator leafDirIterator;
	
	/**
	 * Before each test, this method sets up the following hierarchy in a temporary directory:
	 * 
	 * /
	 * /a.txt
	 * /empty/
	 * /subdir/
	 * /subdir/subsubdir/
	 * /subdir/subsubdir/bar.exe
	 * /subdir/subsubdir/foo.txt
	 * /subdir/yahoo
	 * /z.exe
	 * 
	 * tempFile points at a single temporary file
	 * singleIterator creates a LevelOrderIterator initialized with tempFile
	 * 
	 * tempDir points at the root of the temporary directory
	 * nestedFileIterator creates a LevelOrderIterator initialized with tempDir
	 * 
	 * emptyDir points at /empty/
	 * emptyDirIterator creates a LevelOrderIterator initialized with emptyDir
	 * 
	 * subDir points at /subdir/
	 * subDirIterator creates a LevelOrderIterator initialized with subDir
	 * 
	 * leafDir points at /subdir/subsubdir/
	 * leafDirIterator creates a LevelOrderIterator initialized with leafDir
	 * 
	 * @throws IOException
	 */
	@Before
	public void before() throws IOException {
		tempFile = File.createTempFile("queues", "tmp");
		singleIterator = new LevelOrderIterator(tempFile);
		
		tempDir = Files.createTempDirectory("queues").toFile();
		for (String fileName: new String[] {"a.txt", "z.exe"}) {
			File f = new File(tempDir, fileName);
			f.createNewFile();
		}

		emptyDir = new File(tempDir, "empty");
		emptyDir.mkdir();
		emptyDirIterator = new LevelOrderIterator(emptyDir);
		
		subDir = new File(tempDir, "subdir");
		subDir.mkdir();
		File subDirFile = new File(subDir, "yahoo");
		subDirFile.createNewFile();
		leafDir = new File(subDir, "subsubdir");
		leafDir.mkdir();
		for (String fileName: new String[] {"foo.txt", "bar.exe"}) {
			File f = new File(leafDir, fileName);
			f.createNewFile();
		}
		leafDirIterator = new LevelOrderIterator(leafDir);
		
		nestedDirIterator = new LevelOrderIterator(tempDir);
	}
	
	@After
	public void after() {
		tempFile.delete();
		tempDir.delete();
	}
	
	@SuppressWarnings("unused")
	@Test(expected = FileNotFoundException.class)
	public void testFileNotFound() throws Exception {
		LevelOrderIterator i = new LevelOrderIterator(new File("probablyyoudon'thaveafilewiththisname"));
	}
	
	@Test
	public void testHasNextAtStartSingle() throws Exception {
		assertTrue(singleIterator.hasNext());
	}
	
	@Test
	public void testHasNextAtEndSingle() throws Exception {
		singleIterator.next();
		assertFalse(singleIterator.hasNext());
	}

	@Test(expected = NoSuchElementException.class)
	public void testExceptionAtEndSingle() throws Exception {
		singleIterator.next();
		singleIterator.next();
	}

	@Test
	public void testSingleFile() throws Exception {
		assertTrue(singleIterator.hasNext());
		File f = singleIterator.next();
		assertEquals(tempFile, f);
	}

	@Test
	public void testEmptyDirectory() throws Exception {
		assertTrue(emptyDirIterator.hasNext());
		File f = emptyDirIterator.next();
		assertEquals(emptyDir, f);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testEmptyDirectoryException() throws Exception{
		assertTrue(emptyDirIterator.hasNext());
		emptyDirIterator.next();
		emptyDirIterator.next();
	}

	@Test
	public void testLeafDirIterator() throws Exception {
		assertEquals(leafDir, leafDirIterator.next());
		assertEquals(new File(leafDir, "bar.exe"), leafDirIterator.next());
		assertEquals(new File(leafDir, "foo.txt"), leafDirIterator.next());
	}
	
	@Test
	public void testNestedDirIterator() throws Exception {
		assertEquals(tempDir, nestedDirIterator.next());
		assertEquals(new File(tempDir, "a.txt"), nestedDirIterator.next());
		assertEquals(emptyDir, nestedDirIterator.next());
		assertEquals(subDir, nestedDirIterator.next());
		assertEquals(new File(tempDir, "z.exe"), nestedDirIterator.next());
		assertEquals(leafDir, nestedDirIterator.next());
		assertEquals(new File(subDir, "yahoo"), nestedDirIterator.next());
		assertEquals(new File(leafDir, "bar.exe"), nestedDirIterator.next());
		assertEquals(new File(leafDir, "foo.txt"), nestedDirIterator.next());
		assertFalse(nestedDirIterator.hasNext());
	}
}
