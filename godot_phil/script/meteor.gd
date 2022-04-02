extends KinematicBody2D
class_name Meteor

var velocity = Vector2(-200, 200)

# Called when the node enters the scene tree for the first time.
func _ready():
	return

func _physics_process(delta):
	
	move_and_collide(velocity*delta)
	
	return


func _on_Area2D_body_shape_entered(body_rid, body, body_shape_index, local_shape_index):
	
	# Skip if self
	if body == self:
		return
		
	# Unspawning once it hits something
	self.get_parent().remove_child(self)
	
	return
