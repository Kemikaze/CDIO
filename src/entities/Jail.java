package entities;

public class Jail implements Field {

	private String Title = "Jail";
	private String Description = "Where criminals stay";
	private String Picture = "";
	
	public Jail(){
		
	}
	@Override
	public void landOnField() {
	}

	@Override
	public String getDescription() {
		return Description;
	}

	@Override
	public void setDescription(String desc) {
		Description = desc;
	}

	@Override
	public String getTitle() {
		return Title;
	}

	@Override
	public void setTitle(String titl) {
		Title = titl;
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public void setNumber(int numb) {
		
	}

}