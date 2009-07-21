package org.wicketstuff.jwicket.ui.effect;


import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.wicketstuff.jwicket.ui.AbstractJqueryUiBehavior;



/**
 * You can add an instance of this class to a Wicket {@link Component} to make it
 * a resizable {@link Component}.
 * An instance of this class can be added to one and only one
 * {@link Component}. Another {@link Component} that should have exactly the
 * same behavior needs it's own instance.
 */
public class EffectBehavior extends AbstractJqueryUiBehavior {

	private static final long serialVersionUID = 1L;

	public EffectBehavior() {
		super(	new JavascriptResourceReference(EffectBehavior.class, "effects.core.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.blind.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.bounce.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.clip.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.explode.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.fold.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.highlight.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.pulsate.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.scale.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.shake.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.slide.js"),
				new JavascriptResourceReference(EffectBehavior.class, "effects.transfer.js")
		);
	}
	
	
	
	protected void onBind() {
		super.onBind();

		getComponent().setOutputMarkupId(true);
	}




	/**
	 * @see org.apache.wicket.behavior.AbstractAjaxBehavior#renderHead(org.apache.wicket.markup.html.IHeaderResponse)
	 */
	@Override
	public void renderHead(final IHeaderResponse response) {
		super.renderHead(response);

		new JavascriptResourceReference(EffectBehavior.class, "effects.core.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.blind.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.bounce.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.clip.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.explode.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.fold.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.highlight.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.pulsate.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.scale.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.shake.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.slide.js");
		new JavascriptResourceReference(EffectBehavior.class, "effects.transfer.js");
	}



	
	
	
	@Override
	protected void respond(AjaxRequestTarget target) {
		// do nothing, must supply abstract method
	}
	
	
	

	private void doPulsate(final AjaxRequestTarget target, final int times, final String speed) {
		String jsString = "jQuery('#" + getComponent().getMarkupId() + "').effect('pulsate', { times:" + times + " }, " + speed + ");";
		target.appendJavascript(jsString);
	}


	public EffectBehavior pulsate(final AjaxRequestTarget target, final int times, final EffectSpeed speed) {
		doPulsate(target, times, speed.getSpeed());
		return this;
	}
	public EffectBehavior pulsate(final AjaxRequestTarget target, final int times, final int speedMs) {
		doPulsate(target, times, String.valueOf(speedMs));
		return this;
	}

	
	
	
	
	
	private void doPuff(final AjaxRequestTarget target, final int percent, final String speed) {
		String jsString = 	"var originalStyle = jQuery('#" + getComponent().getMarkupId() + "').attr('style');" +
							"jQuery('#" + getComponent().getMarkupId() + "').effect('puff', { percent:" + percent + " }, " + speed + ", "+
		
							"function() {jQuery('#" + getComponent().getMarkupId() + "').attr('style',originalStyle);" +
										"jQuery('#" + getComponent().getMarkupId() + "').fadeIn(); }" +
		
							");";
		target.appendJavascript(jsString);
	}


	public EffectBehavior puff(final AjaxRequestTarget target, final int percent, final EffectSpeed speed) {
		doPuff(target, percent, speed.getSpeed());
		return this;
	}
	public EffectBehavior puff(final AjaxRequestTarget target, final int percent, final int speedMs) {
		doPuff(target, percent, String.valueOf(speedMs));
		return this;
	}

	
	
	
	
	
	private void doExplode(final AjaxRequestTarget target, final int pieces, final String speed) {
		String jsString =	"var originalStyle = jQuery('#" + getComponent().getMarkupId() + "').attr('style');" +
							"jQuery('#" + getComponent().getMarkupId() + "').effect('explode', { pieces:" + pieces + " }, " + speed + ", "+
							"function(){jQuery('#" + getComponent().getMarkupId() + "').attr('style',originalStyle);" +
							           "jQuery('#" + getComponent().getMarkupId() + "').fadeIn(); }" +
							");";
		target.appendJavascript(jsString);
	}


	public EffectBehavior explode(final AjaxRequestTarget target, final int pieces, final EffectSpeed speed) {
		doExplode(target, pieces, "'" + speed.getSpeed() + "'");
		return this;
	}
	public EffectBehavior explode(final AjaxRequestTarget target, final int pieces, final int speedMs) {
		doExplode(target, pieces, String.valueOf(speedMs));
		return this;
	}
	
	
	
	
}