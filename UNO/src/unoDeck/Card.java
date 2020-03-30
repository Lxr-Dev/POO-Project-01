package unoDeck;

public class Card {
	
	private Integer value;
	private Integer color;
	private String img;
	private String type;
	
	
	public Card() {
		
	}
	
	public Card(Integer value, Integer color, String img, String type) {
		setValue(value);
		setColor(color);
		setImg(img);
		setType(type);
	}
	
	public Integer getValue() {
		return value;
	}
	private void setValue(Integer value) {
		if (value >=0 && value <=16) {
			this.value = value;
		}
		
	}
	
	public Integer getColor() {
		return color;
	}
	private void setColor(Integer color) {
		if (color >=0 && color<=4) {
			this.color = color;
		}
		
	}
	public void ChangeColor(Integer color) {
		if (color >=0 && color<=4) {
			this.color = color;
		}
		
	}
	
	public String getImg() {
		return img;
	}
	/**
	 * En este set se debe validar que recurso de imagen usar al momento de hacer la asignación de cartas
	 * */
	private void setImg(String img) {
		this.img = img;
	}
	
	public String getType() {
		return type;
	}
	private void setType(String type) {
		if (type.matches("(numeric)|(special)")) {
			this.type = type;
		}
	}
	

}
