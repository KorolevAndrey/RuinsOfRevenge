/*
 * Copyright (c) 2012 matheusdev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.matheusdev.ddm.entity;

import org.matheusdev.ddm.Resource;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;


/**
 * @author matheusdev
 *
 */
public class EntityBall extends Entity {

	public static Resource[] require() {
		return new Resource[] {
				new Resource("data/sprites/ball.png", Texture.class)
		};
	}

	private final Sprite sprite;

	/**
	 * @param body
	 * @param sprites
	 */
	public EntityBall(float x, float y, EntityManager entityManager) {
		super(createCircularBody(x, y, 0.15f, 0.7f, 0.4f, 0.5f, entityManager.getPhysics()));
		uploadAsUserData(body);
		sprite = new Sprite(entityManager.getResources().getRegion("ball"));
	}

	/* (non-Javadoc)
	 * @see org.matheusdev.ddm.collision.Collidable#collide(com.badlogic.gdx.physics.box2d.Fixture, com.badlogic.gdx.physics.box2d.Contact, com.badlogic.gdx.physics.box2d.Manifold)
	 */
	@Override
	public void collide(Fixture other, Contact contact, Manifold manifold) {
	}

	/* (non-Javadoc)
	 * @see org.matheusdev.ddm.entity.Entity#tick(org.matheusdev.ddm.entity.EntityHandler, float)
	 */
	@Override
	public void tick(EntityManager handler, float delta) {
		body.setAngularVelocity(2f);
	}

	/* (non-Javadoc)
	 * @see org.matheusdev.ddm.entity.Entity#draw(org.matheusdev.ddm.entity.EntityHandler, com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void draw(EntityManager handler, SpriteBatch batch) {
		draw(sprite, body, 0.3f, batch);
	}

}