;;; Sierra Script 1.0 - (do not remove this comment)
(script# 51)
(include game.sh)
(use Main)
(use Intrface)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm51 0
)

(local
	local0
)
(instance rm51 of Room
	(properties
		picture 51
		style WIPELEFT
		east 551
	)
	
	(method (init)
		(LoadMany VIEW 52 3 146 533 148 251 145 16 0)
		(super init:)
		(ego init: x: 218 y: 140)
		(NormalEgo)
		(HandsOff)
		(dragHead init:)
		(dragonBody init: setPri: 1 ignoreActors: TRUE stopUpd:)
		(if (!= howFast 0) (smoke init: setCycle: Forward))
		(oldDragon init: setCycle: Walk)
		(self setScript: removeSmallDragon)
	)
)

(instance removeSmallDragon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(oldDragon setMotion: DPath 10 131 -25 131 self)
				(dragHead setCycle: EndLoop self)
				(smoke hide:)
			)
			(1
				(DisplayNewGraphics)
				(dragHead stopUpd:)
				(smoke posn: 119 98 show:)
				(= cycles 1)
			)
			(2
				(ego view: 52 setLoop: 1 setCycle: 0)
				(= cycles 6)
			)
			(3
				(ego setCycle: Walk setMotion: MoveTo 255 138)
				(Print 51 0 #at 25 20 #width 260 #mode teJustCenter #dispose)
			)
			(4 (ego view: 0) (= cycles 1))
			(5
				(cls)
				(self dispose:)
				(curRoom setScript: flameEgo)
			)
		)
	)
)

(instance flameEgo of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			(
				(and
					(== state 1)
					(== (ego view?) 0)
					(> (fireBall x?) 120)
				)
				(ego view: 16 setLoop: 1 setCycle: EndLoop)
			)
			(
			(and (> (fireBall x?) 255) (== (ego view?) 16)) (ego setLoop: 1 setCycle: CycleTo BegLoop 0))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke hide:)
				(dragHead stopUpd:)
				(fireHead
					init:
					posn: 92 105
					ignoreActors:
					cycleSpeed: 2
					cel: 0
					setPri: 12
					setCycle: EndLoop self
				)
			)
			(1
				(fireHead hide:)
				(fireBall
					init:
					setLoop: (if (< (ego y?) 142) 3 else 2)
					ignoreActors:
					ignoreHorizon:
					setPri: 4
					illegalBits: 0
					setCycle: Forward
				)
				(fireBall posn: 126 102)
				(fireBall
					xStep: 12
					moveSpeed: 0
					setMotion: MoveTo 350 (- (ego y?) 40) self
				)
			)
			(2
				(ego view: 3 loop: 2 setCycle: CycleTo 1 1 self)
			)
			(3
				(fireHead show: setCycle: EndLoop self)
			)
			(4
				(fireHead hide:)
				(fireBall
					init:
					setLoop: (if (< (ego y?) 142) 3 else 2)
					ignoreActors:
					ignoreHorizon:
					setPri: 4
					illegalBits: 0
					setCycle: Forward
				)
				(fireBall posn: 126 102)
				(fireBall
					xStep: 12
					moveSpeed: 0
					setMotion: MoveTo (+ (ego x?) 5) (- (ego y?) 20) self
				)
			)
			(5
				(fireBall hide:)
				(ego view: 3 setLoop: 3 setCel: 0)
				(= cycles 6)
			)
			(6
				(ego
					view: 52
					setLoop: 2
					setCycle: Walk
					xStep: 9
					moveSpeed: 0
					setMotion: DPath 10 128 -40 128 self
				)
			)
			(7
				((ScriptID 0 6) loop: 1 fade:)
				(= cycles 1)
			)
			(8 (curRoom newRoom: 22))
		)
	)
)

(instance raiseHead of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dragHead setCycle: EndLoop self)
				(smoke hide:)
			)
			(1
				(dragHead stopUpd:)
				(smoke posn: 119 98 show:)
				(DisposeScript raiseHead)
			)
		)
	)
)

(instance dragonBody of Actor
	(properties
		x 117
		y 126
		view 251
		loop 3
	)
)

(instance dragonHead of Actor
	(properties
		x 36
		y 87
		view 148
		cel 3
		priority 9
		signal (| ignrHrz fixedLoop blocked fixedLoop stopUpdOn) ;$2c11
		illegalBits $0000
	)
)

(instance oldDragon of Actor
	(properties
		x 160
		y 143
		view 533
		loop 1
		cel 2
	)
)

(instance smoke of Actor
	(properties
		x 114
		y 93
		view 146
		loop 1
		cel 2
		priority 10
		signal fixPriOn
	)
)

(instance puff of Actor
	(properties
		view 251
		loop 1
		moveSpeed 1
	)
)

(instance fireHead of Prop
	(properties
		view 145
		loop 1
		signal notUpd
		cycleSpeed 1
	)
)

(instance fireBall of Actor
	(properties
		yStep 6
		view 146
		xStep 8
	)
)

(instance dragHead of Prop
	(properties
		x 41
		y 90
		view 145
		cycleSpeed 1
	)
)
