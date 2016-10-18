
public class Racer
	{
		String name;
		String plane;
		String country;
		int point;
		
		public Racer (String n, String p, String a, int t)
		{
			name = n;
			plane = p;
			country = a;
			point = t;
			
		}
		public String getName()
			{
				return name;
			}


		public void setName(String name)
			{
				this.name = name;
			}


		public String getPlane()
			{
				return plane;
			}


		public void setPlane(String plane)
			{
				this.plane = plane;
			}


		public String getCountry()
			{
				return country;
			}


		public void setCountry(String country)
			{
				this.country = country;
			}


		public int getPoint()
			{
				return point;
			}


		public void setPoint(int point)
			{
				this.point = point;
			}


		@Override
		public String toString()
			{
				return "Racers [name=" + name + ", plane=" + plane + ", country=" + country + "]";
			}

	}