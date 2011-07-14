package it.marteEngine.test.particles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;

import it.marteEngine.World;
import it.marteEngine.entity.ParticlesEntity;
import it.marteEngine.test.fuzzy.RingEmitter;

public class ParticlesWorld extends World {

	private ParticlesEntity whirl, simpleEmitter, ringEmitter;
	
	public ParticlesWorld(int id, GameContainer container) {
		super(id, container);
		particleSystem = new ParticleSystem("data/data/particle.tga", 1000);	// max particles = 1000
		particleSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		
		whirl = new ParticlesEntity(container.getWidth()/2, container.getHeight()/2, null, "data/data/teleportemitter.xml");
		this.add(whirl);

		simpleEmitter = new ParticlesEntity(container.getInput().getMouseX(), container.getInput().getMouseY(), null, "data/data/simpleEmitter.xml");
		this.add(simpleEmitter);
		
		ringEmitter = new ParticlesEntity(400, 400, new RingEmitter(400,400));
		this.add(ringEmitter);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// update all entities
		super.update(container, game, delta);

		simpleEmitter.x = container.getInput().getMouseX();
		simpleEmitter.y = container.getInput().getMouseY();
		
		if (whirl.visible == false) {
			// whirl over. restart again
			whirl = new ParticlesEntity(container.getWidth()/2, container.getHeight()/2, null, "data/data/teleportemitter.xml");
			this.add(whirl);
			
		}
	}
}
