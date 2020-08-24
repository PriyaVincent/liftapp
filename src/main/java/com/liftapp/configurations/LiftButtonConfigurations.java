package com.liftapp.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:liftbutton.properties")
@ConfigurationProperties("lift")
public class LiftButtonConfigurations {

	private List<Button> buttons = new ArrayList<>();

	public static class Button {

		private Integer id;
		private String direction;
		private Integer floor;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDirection() {
			return direction;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}

		public Integer getFloor() {
			return floor;
		}

		public void setFloor(Integer floor) {
			this.floor = floor;
		}

		@Override
		public String toString() {
			return "Button [id=" + id + ", direction=" + direction + ", floor=" + floor + "]";
		}

	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	@Override
	public String toString() {
		return "LiftButtonConfigurations [buttons=" + buttons + "]";
	}

}
