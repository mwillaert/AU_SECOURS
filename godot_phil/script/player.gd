extends KinematicBody2D
class_name Player

# Vars
var speed = 400
var current_direction = DIRECTION.NONE
var velocity := Vector2(0, 0)
var can_jump := false

const GRAVITY = 10*2
var MAX_VELOCITY = Vector2(speed*2, speed*2)

enum DIRECTION {
	NONE,
	UP,
	UP_LEFT,
	UP_RIGHT,
	DOWN,
	DOWN_LEFT,
	DOWN_RIGHT
	LEFT,
	RIGHT,
}


func _ready():
	return


func get_input():
	
	# Getting each input
	if Input.is_action_pressed("ui_up"):
		current_direction = DIRECTION.UP
	
	if Input.is_action_pressed("ui_left"):
		
		if Input.is_action_pressed("ui_up"):
			current_direction = DIRECTION.UP_LEFT
		else:
			current_direction = DIRECTION.LEFT
	
	if Input.is_action_pressed("ui_right"):
		
		if Input.is_action_pressed("ui_up"):
			current_direction = DIRECTION.UP_RIGHT
		else:
			current_direction = DIRECTION.RIGHT
		
	return


func process_input(delta):
	
	# Init velocity
	var dvelocity = Vector2(0, 0)
	
	# Getting each input
#	if Input.is_action_pressed("ui_up"):
#		dvelocity.y += -1
#
	if Input.is_action_pressed("ui_left"):
		dvelocity.x += -1
	
	if Input.is_action_pressed("ui_right"):
		dvelocity.x += 1
	
	# Applying velocity
#	dvelocity = velocity.normalized()
	dvelocity *= speed
	
	velocity += dvelocity
	
	# Applying drag
	if dvelocity.x != 0:
		velocity.x = lerp(velocity.x, dvelocity.x * speed, 0.5)
	else:
		velocity.x = lerp(velocity.x, 0, 0.1)
	
	if Input.is_action_pressed("ui_up"):
		if can_jump and is_on_floor():
			velocity.y = -4*speed
			can_jump = false
	
	return


func process_movement():
	
#	print(velocity)
	
	# Moving
	move_and_slide(velocity, Vector2(0, -1))
	
	# Resetting direction
#	current_direction = DIRECTION.NONE
	
	return


func apply_gravity():

	# Checking if on floor
	if is_on_floor():
		can_jump = true
		velocity.y = 0
		return
	
	velocity += Vector2(0, GRAVITY)
	
	return


func check_velocity():
	
	velocity.x = min(abs(velocity.x), MAX_VELOCITY.x) * (sign(velocity.x))
	velocity.y = min(abs(velocity.y), MAX_VELOCITY.y) * (sign(velocity.y))
	
	if velocity.y < 0:
		return
	
	return


func _physics_process(delta):
	
	# Input handling
	get_input()
	apply_gravity()
	process_input(delta)
	
	# Checking max velocity
	check_velocity()
	
	# Handling movement
	process_movement()
	
	return


func _on_body_entered(body):
	
	# Skip self
	if body == self:
		return
	
	# Resetting vertical velocity
	velocity.y = 0
	
	return
