package de.randi2.jsf.backingBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import de.randi2.jsf.controllerBeans.LoginHandler;
import de.randi2.jsf.controllerBeans.TrialHandler;
import de.randi2.model.randomization.BlockRandomizationConfig;

public class BlockR {
	
	public static enum BlockDesignTypeId {
		VARIABLE_BLOCK("variableBlockSize"), CONSTANT_BOLCK("constantBlockSize");

		private String id = null;

		private BlockDesignTypeId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return this.id;
		}
	}

	private List<SelectItem> blockRandTypes;

	public List<SelectItem> getBlockRandTypes() {
		if (blockRandTypes == null) {
			ValueExpression ve = FacesContext.getCurrentInstance()
					.getApplication().getExpressionFactory()
					.createValueExpression(
							FacesContext.getCurrentInstance().getELContext(),
							"#{loginHandler}", LoginHandler.class);
			LoginHandler currentLoginHandler = (LoginHandler) ve
					.getValue(FacesContext.getCurrentInstance().getELContext());
			ResourceBundle bundle = ResourceBundle.getBundle(
					"de.randi2.jsf.i18n.algorithms", currentLoginHandler
							.getChosenLocale());
			blockRandTypes = new ArrayList<SelectItem>();
			blockRandTypes.add(new SelectItem(BlockDesignTypeId.CONSTANT_BOLCK
					.toString(), bundle
					.getString(BlockRandomizationConfig.class
							.getCanonicalName()
							+ ".constantBlockSize")));
			blockRandTypes.add(new SelectItem(BlockDesignTypeId.VARIABLE_BLOCK
					.toString(), bundle
					.getString(BlockRandomizationConfig.class
							.getCanonicalName()
							+ ".variableBlockSize")));

		}
		return blockRandTypes;
	}

	private String selectedBlockRandTypes;
	private boolean renderVariable = false;

	public String getSelectedBlockRandTypes() {
		return selectedBlockRandTypes;
	}

	public void setSelectedBlockRandTypes(String selectedBlockRandTypes) {
		this.selectedBlockRandTypes = selectedBlockRandTypes;
		if (selectedBlockRandTypes.equals(BlockDesignTypeId.VARIABLE_BLOCK
				.toString())) {
			renderVariable = true;

		} else
			renderVariable = false;
	}

	public boolean isRenderVariable() {
		return renderVariable;
	}

	public void minValueChanged(ValueChangeEvent event) {
		// set maximum block size to minimum block size, in case of constant
		// block design
		if (!renderVariable) {
			((BlockRandomizationConfig) getCurrentTrialHandler()
					.getRandomizationConfig()).setMaximum((Integer) event
					.getNewValue());
		}
	}

	private TrialHandler getCurrentTrialHandler() {
		ValueExpression ve = FacesContext.getCurrentInstance().getApplication()
				.getExpressionFactory().createValueExpression(
						FacesContext.getCurrentInstance().getELContext(),
						"#{trialHandler}", TrialHandler.class);
		return (TrialHandler) ve.getValue(FacesContext.getCurrentInstance()
				.getELContext());
	}

}