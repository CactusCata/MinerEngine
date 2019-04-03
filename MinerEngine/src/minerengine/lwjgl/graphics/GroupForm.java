package minerengine.lwjgl.graphics;

import java.util.Map;
import java.util.TreeMap;

public class GroupForm {

	private final Map<String, FormRender> map = new TreeMap<>();

	public void add(FormRender value) {
		this.map.put(value.toString(), value);
	}

	public void add(FormRender... values) {
		for (FormRender value : values)
			this.add(value);
	}

	public void draw() {

		String oldest = null;
		FormRender valueOld = null;
		for (String i : this.map.keySet()) {
			FormRender form = this.map.get(i);
			if (oldest == null || oldest != i) {
				if (valueOld != null)
					valueOld.end();
				form.begin();
				oldest = i;
			}

			form.render();
			valueOld = form;

			if (this.map.get(this.map.keySet().toArray()[this.map.size() - 1]) == form)
				form.end();

		}

	}

}
