package driver;
import java.util.Scanner;
//import java.util.Iterator;
import java.util.*;




public class PlayerDriver 
{
	static ArrayList<Album> albums=new ArrayList<>();
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		Album album = new Album("Album1","AC/DC");

		album.addSong("Aaaa",2.5);
		album.addSong("Bbbb",3.8);
		album.addSong("Cccc",4);

		albums.add(album);

		album = new Album("Album2","AC/DC");

		album.addSong("daaa",2.5);
		album.addSong("kbbb",3.8);
		album.addSong("lccc",4);

		albums.add(album);

		/*for(int i=0;i<albums.size();i++)
		{
			System.out.println(albums.get(i));
		}*/


		LinkedList<Song> playList1=new LinkedList<>();


        albums.get(0).addToPlayList("Aaaa",playList1);
	    albums.get(0).addToPlayList("Bbbb",playList1);
		albums.get(1).addToPlayList("daaa",playList1);
	    albums.get(1).addToPlayList("kbbb",playList1);

		play(playList1);

	}

	public static void play(LinkedList<Song> playList)
	{
		Scanner sc=new Scanner(System.in);

		boolean quit=false;
		boolean forward=true;

		ListIterator<Song> listIterator=playList.listIterator();

		if(playList.size()==0)
		{
			System.out.println("This Playlist is empty");

		}
		else
		{
			System.out.println("Now Playing "+listIterator.next().toString());
			printMenu();
		}

		while(!quit)
		{
			int action=sc.nextInt();
			sc.nextLine();

			switch(action)
			{
				case 0:
					System.out.println("PlayList Complete");
				    quit=true;
					break;

				case 1:
					if(!forward)
				     {
					    if(listIterator.hasNext())
						 {
							listIterator.next();
						 }
						 forward=true;
				      }
					  if(listIterator.hasNext())
				         {
							System.out.println(" Now Playing "+listIterator.next().toString());
				         }
					  else
				        {
							System.out.println("No songs available, reached to the end of the palylist ");
							forward=false;
				        }
						break;


				case 2:
					if(forward)
				      {
						if(listIterator.hasPrevious())
						  {
							listIterator.previous();
						  }
						  forward=false;
				      }
					  if(listIterator.hasPrevious())
				         {
							System.out.println(" Now Playing "+listIterator.previous().toString());
				         }
					  else
				        {
							System.out.println("We are at first song ");
							forward=false;
				        }
						break;

				case 3:
					if(forward)
				     {
					    if(listIterator.hasPrevious())
						 {
							System.out.println(" Now Playing "+listIterator.previous().toString());
							forward=false;
						 }
						 else
						 {
							System.out.println("We are at the start of the playList ");
						 }
					
			       	 }
					 else
				      {
						if(listIterator.hasNext())
						  {
							System.out.println(" Now Playing "+listIterator.next().toString());
							forward=false;
						  }
						  else {
                            System.out.println("we have reached to the end of list");
                        }
				      }
					  break;

				case 4:
					printList(playList);
				    break;

				case 5:
					printMenu();
				    break;

				case 6:
					if(playList.size()>0)
				    {
						listIterator.remove();

						if(listIterator.hasNext())
						{
							System.out.println("Now playing "+listIterator.next().toString());
						}
						else
						{
							if(listIterator.hasPrevious())
							{
								System.out.println("Now playing "+listIterator.next().toString());
							}
						}
				    }
			}
		}

     
	}

	private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
	private static void printList(LinkedList<Song> playList)
		{
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext())
			{
            System.out.println(iterator.next());
            }

        System.out.println("-----------------");
       }

	   
}
