package GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

class Dot {
    private Path2D path = new Path2D.Double();
    private Color color;

    public Dot(Shape shape) {
        path.append(shape, true);
        Color color = Color.getHSBColor(0.5f, 0.5f, 0.0f);
        this.color = color;
    }

    public boolean contains(Point p) {
        return path.contains(p);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.draw(path);
    }

    public void fill(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(path);
    }

    public void translate(int deltaX, int deltaY) {
        path.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
    }

}