package com.rock.cybski.designPattern.decorator;

public abstract class Decorator extends Component {
	
	protected Component component;
	
	public void setComponent(Component component){
		this.component = component;
	}

	@Override
	public void operation() {
		if(component != null){
			component.operation();
		}

	}

}
