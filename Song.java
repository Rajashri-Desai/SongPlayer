package driver;
class Song 
{
	String title;
	double duration;

	Song(String title,double duration)
	{
		this.title=title;
		this.duration=duration;
	}

    public String getTitle()
	{
		return title;
	}

	public double getDuration()
	{
		return duration;
	}

    
    @Override
	public String toString()
	{
		return "Song [ Title : "+title+", Duration : "+duration+" ]";
	}
}