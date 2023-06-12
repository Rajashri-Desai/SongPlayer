package driver;
import java.util.ArrayList;
import java.util.LinkedList;
class Album 
{
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist)
	{
		this.name=name;
		this.artist=artist;
		this.songs=new ArrayList<Song>();
     }

	 @Override
	public String toString()
	{
		return "Album [ name : "+name+", artist : "+artist+" ]";
	}

	 public Song findSong(String title)
	{
		for(Song checkSong:songs)
		{
			if(checkSong.getTitle().equals(title))
			{
				return checkSong;
		    }
			
		}
		return null;
	}

	public boolean addSong(String title,double duration)
	{
		if(findSong(title)!=null)
		{
			System.out.println("Song is Alraedy exist");
			return false;
		}
		else
		{
			songs.add(new Song(title,duration));
			return true;
		}
	}

   public boolean addToPlayList(int trackno,LinkedList<Song> playList)
	{
	    int index=trackno-1;
		if(index>=1 && index<=songs.size())
		{
			playList.add(songs.get(index));
			return true;
		}
		return false;
		
	}

	public boolean addToPlayList(String title, LinkedList<Song> PlayList)
		{
        for(Song checkedSong : this.songs)
			{
            if (checkedSong.getTitle().equals(title))
				{
                PlayList.add(checkedSong);
                return true;
                 }
            }

                return false;
		}
}